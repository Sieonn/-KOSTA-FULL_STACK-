a= input()
b=input()
sum=[]
for i in range(b):
    sum[i] = int(a)*int(b[i])*10**(2-i)
print(sum)