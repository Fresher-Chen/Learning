import os
import chardet


def findFile(path,string):
    with open(path,"rb") as f:
        i=0
        for line in f:
            i+=1;
            if string in line.decode(encoding="GBK"):
                print("   "+path+"  Line:",i)


def start():
    choose = input("Current Dir?(Y/n)")
    path=""
    print(os.getcwd())
    if(choose.strip()=="" or choose.strip().upper()=="Y"):
        path=os.getcwd()+path
    elif choose.strip()=="n":
        path = input("Dir:")
    else:
        print("Invalid Input!")
        return
    string = input("String:")
    filenames = os.listdir(path)
    for filename in filenames:
        if filename[-4:]==".cpp" or filename[-2:]==".h":
            findFile(path+"/"+filename,string)
        else:
            continue
    print("Search Done!!!")


if __name__ == "__main__":
    while(1):
        start()

    
