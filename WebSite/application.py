from flask import Flask, flash, jsonify, redirect, render_template, request, session
from flask_session import Session
from flask_caching import Cache
from helper import readFile, readAnswer, runningCode, readExplain, cleanCache
from simdHelper import readSimdFile

config = {
    "DEBUG": True,          # some Flask specific configs
    "CACHE_TYPE": "simple", # Flask-Caching related configs
    "CACHE_DEFAULT_TIMEOUT": 300,
    "TEMPLATES_AUTO_RELOAD": True
}
app = Flask(__name__)
# tell Flask to use the above defined config
app.config.from_mapping(config)
cache = Cache(app)
# Ensure templates are auto-reloaded
startQuestion = 1
endQuestion = 42
questionPerLine = 30
default_qid = 1

# Ensure responses aren't cached
@app.after_request
def after_request(response):
    response.headers["Cache-Control"] = "no-cache, no-store, must-revalidate"
    response.headers["Expires"] = 0
    response.headers["Pragma"] = "no-cache"
    return response
Session(app)

@app.route("/", methods=["GET", "POST"])
def index():
    return render_template("index.html")

@app.route("/avx-performance", methods=["GET", "POST"])
def avx_performance():
    simdContent = readSimdFile("SIMD.cpp")
    assemblyContent = readSimdFile("Assembly.txt")
    return render_template("avx-performance.html", assem = assemblyContent ,content = simdContent)

@app.route("/hpc-vector", methods=["GET", "POST"])
def hpc_vector():
    return render_template("HPC-vector.html")

@app.route("/counting-process", methods=["GET", "POST"])
def counting_process():
    return render_template("counting-process.html")

@app.route("/poisson-process", methods=["GET", "POST"])
def poisson_process():
    return render_template("poisson-process.html")

@app.route("/markov-process", methods=["GET", "POST"])
def markov_process():
    return render_template("markov-process.html")

@app.route("/gaussian-process", methods=["GET", "POST"])
def gaussian_process():
    return render_template("gaussian-process.html")

@app.route("/stationary-process", methods=["GET", "POST"])
def stationary_process():
    return render_template("stationary-process.html")

@app.route("/stochastic-calculus", methods=["GET", "POST"])
def stochastic_calculus():
    return render_template("stochastic-calculus.html")

@app.route("/levy-process", methods=["GET", "POST"])
def levy_process():
    return render_template("levy-process.html")

@app.route("/project-euler", methods=["GET", "POST"])
def project_euler():
    tableRange = list()
    question_id = default_qid
    for i in range(startQuestion, endQuestion - questionPerLine, questionPerLine):
        tableRange.append(list(range(i, i + questionPerLine)))
    tableRange.append(list(range(tableRange[-1][-1] + 1, endQuestion + 1)))
    if request.method == "POST":
        question_id = request.form.get("question_id")
    title, content = readFile(question_id)
    cache.set("qid", question_id)
    cache.set("title", title)
    cache.set("content", content)
    code = readAnswer(question_id)
    explain = readExplain(question_id)
    cache.set("explain", explain)
    return render_template("project-euler.html", question_solved = tableRange, qid = question_id, 
    title = title, content = content, answer = code, explain = explain)

@app.route("/running_code", methods=["GET", "POST"])
def running_code():
    tableRange = list()
    question_id = default_qid
    for i in range(startQuestion, endQuestion - questionPerLine, questionPerLine):
        tableRange.append(list(range(i, i + questionPerLine)))
    tableRange.append(list(range(tableRange[-1][-1] + 1, endQuestion + 1)))
    question_id = cache.get("qid")
    title = cache.get("title")
    content = cache.get("content")
    explain = cache.get("explain")
    if request.method == "POST":
        codeSnippet = request.form.get("code")
    ipAddress = request.remote_addr
    result = runningCode(codeSnippet, question_id, ipAddress)
    cleanCache(question_id, ipAddress)
    return render_template("project-euler.html", question_solved = tableRange, qid = question_id, 
    title = title, content = content, answer = codeSnippet, explain = explain, result = result, scroll='code_panel')

@app.route("/about", methods=["GET", "POST"])
def about():
    return render_template("about.html")

if __name__ == '__main__':
    app.debug = True
    app.run()