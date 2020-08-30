import os
import sys
import threading
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
    f = open("EulerAList/pset" + str(qid) + ".cpp", "r")
    content = f.read()
    f.close()
    return content

def readExplain(qid):
    f = open("EulerExplainList/Q" + str(qid) + ".txt", "r")
    content = f.read()
    f.close()
    return content

def runningCode(code, qid, ipAddress):
    ipAddress = ipAddress + qid
    text_file = open("./tmpCache/" + ipAddress +"tmp.cpp", "w")
    n = text_file.write(code)
    text_file.close()
    ##Compile:
    try:
        out = subprocess.check_output('g++ tmpCache/' + ipAddress + 'tmp.cpp -o tmpCache/tmp' + ipAddress, stderr=subprocess.STDOUT,shell=True)
    except subprocess.CalledProcessError as exc:
        return exc.output.decode('utf8')
    try:
        output = subprocess.check_output('tmpCache/tmp' + ipAddress, stderr=subprocess.STDOUT,shell=True,timeout=10)
        return output.decode('utf8')
    except subprocess.TimeoutExpired as exc:
        return "Process Time Out!"
    except subprocess.CalledProcessError as exc:
        return exc.output.decode('utf8')

def cleanCache(qid, ipAddress):
    ipAddress = ipAddress + str(qid)
    out = subprocess.check_output('rm tmpCache/' + ipAddress + 'tmp.cpp', stderr=subprocess.STDOUT,shell=True)
    out = subprocess.check_output('rm -f tmpCache/tmp' + ipAddress, stderr=subprocess.STDOUT,shell=True)



   

