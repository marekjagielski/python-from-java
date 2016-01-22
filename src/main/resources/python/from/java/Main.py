import threading, sys

class Main(object):

    def __init__(self):
        self.closed = False

    def run(self):
        while not self.closed:
            try:
                t = threading.Thread(target=self.handle)
                t.setDaemon(True)
                t.start()
            except KeyboardInterrupt:
                raise

    def handle(self):
        print("PY : handle")
        while True:
            #sys.stdout.flush()
            #sys.stderr.flush()
            pass

    def close(self):
        self.closed = True
        print("PY : close")

if __name__ == "__main__":
    print("PY : START")
    m = Main()
    m.run()
    print("PY : END")

