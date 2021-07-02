
file = open("settings.txt","r").readlines()

settings = dict()

#print("Here")
tmp = ""
for x in file[:-1]:
    tmp = x.split(" = ")
    settings[tmp[0]] = tmp[1][:-1]

tmp = file[-1].split(" = ")
settings[tmp[0]] = tmp[1]

print(settings)
