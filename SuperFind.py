import os
import chardet


def findStr(path,string):
    with open(path,"rb") as f:
        i=0
        for line in f:
            i+=1;
            try:
                if string in line.decode(encoding="GBK"):
                    print("   "+path+"  Line:",i)
            except UnicodeDecodeError:
                continue


def walkPath(path,string):
    
    filenames = os.listdir(path)
    for filename in filenames:
        #print(">>> "+path+"/"+filename)
        if os.path.isdir(filename):
            walkPath(path+"/"+filename,string)
        elif filename[-4:]==".cpp" or filename[-2:]==".h" or filename[-3:]==".py":
            findStr(path+"/"+filename,string)
        else:
            continue


if __name__ == "__main__":
    while(1):
        choose = input("Current Dir?(Y/n)")
        path=""
        print(os.getcwd())
        if(choose.strip()=="" or choose.strip().upper()=="Y"):
            path=os.getcwd()+path
        elif choose.strip()=="n":
            path = input("Dir:")
        else:
            print("Invalid Input!")
            continue
        string = input("String:")
        walkPath(path,string)
        print("Search Done!!!")
        


    
