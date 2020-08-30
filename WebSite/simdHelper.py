def readSimdFile(fname):
    f = open("Vectorization/" + fname, "r")
    content = f.read()
    f.close()
    return content