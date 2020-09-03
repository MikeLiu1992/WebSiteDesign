import os
import sys
import threading
import stat
import subprocess

##Project Euler Helper Function
def specialqid(qid):
    f = open("EulerAList/pset" + str(qid) + "/pset" + str(qid) + ".cpp", "r")
    content = f.read()
    f.close()
    return content 

def readFile(qid):
    f = open("EulerQList/Q" + str(qid) + ".txt", "r")
    title = f.readline()
    lines = f.readlines()
    content = []
    for line in lines:
        content.append(line.strip())
    f.close()
    return title, content

def readAnswer(qid):
    f = open("EulerAList/pset" + str(qid) + ".py", "r")
    content = f.read()
    f.close()
    return content

def readExplain(qid):
    f = open("EulerExplainList/Q" + str(qid) + ".txt", "r")
    content = f.read()
    f.close()
    return content

def runningCode(code, qid, ipAddress):
    ipAddress = str(ipAddress) + str(qid)
    text_file = open("/tmp/" + ipAddress +"tmp.py", "w+")
    n = text_file.write(code)
    text_file.close()
    try:
        out = subprocess.check_output('python3 /tmp/' + ipAddress + 'tmp.py', stderr=subprocess.STDOUT,shell=True,timeout=10)
        return out.decode('utf8')
    except subprocess.CalledProcessError as exc:
        return exc.output.decode('utf8')

def cleanCache(qid, ipAddress):
    ipAddress = ipAddress + str(qid)
    if os.path.exists('/tmp/' + ipAddress + 'tmp.py'):
        os.remove('/tmp/' + ipAddress + 'tmp.py')



   

