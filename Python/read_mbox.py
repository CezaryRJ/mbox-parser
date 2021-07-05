import mailbox
import sys

from frame import *


box = mailbox.mbox(sys.argv[1])

settings = read_setings()

out = open("C:\\Users\\Cezary\\Documents\\GitHub\\mbox-parser\\results\\p","w")

iter = box.iterkeys()

counter = 0

for x in iter:

    msg = box.get_message(x)

#    if counter == 11:
#        print(msg.get_payload())

    if not msg.is_multipart():

        msg = box.get_message(x)
        #print(msg.get_payload())
        #exit()
        #print(str(len(msg.get_payload())) + "\n")
        out.write(str(len(msg.get_payload().strip())) + "\n")

    else:

        tmp = ""
        for part in msg.walk():
            if part.get_content_type() == "text/plain":
                tmp += part.get_payload()
		#print(mime_mail["Content"])(
    #    print(tmp)
        out.write(str(len(tmp.strip())) + "\n")

    counter = counter + 1

print(len(box))

out.write(str(len(box)))

out.close()
