import socket

if __name__ == '__main__':
    s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    s.connect(('rtd.hpwren.ucsd.edu', 12020))

    for i in range(0, 60):
        d = s.recv(1024)
        p = d.split('\t'.encode(), 2)
        print(str(i) + " : " + str(p[2]))
        # print("{0}: {1}".format(i, p[2]))
    s.close()