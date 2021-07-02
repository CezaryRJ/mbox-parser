import mailbox
import sys

from frame import *


box = mailbox.mbox(sys.argv[1])

settings = read_setings()

out = open("C:\\Users\\Cezary\\Documents\\GitHub\\mbox-parser\\results\\p","w")

print(len(box))

out.write(str(len(box)))

out.close()
