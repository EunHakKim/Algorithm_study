import sys
from collections import deque
input = sys.stdin.readline

N=int(input().strip())
dist = [[-1]*(N+1) for _ in range(N+1)]
for i in range(1,N+1):
    dist[i][i]=0

for _ in range(1, N+1):
    connect = list(map(int, input().strip().split()))
    for i in range(1, len(connect)//2 - 1):
        dist[connect[0]][connect[i*2 - 1]] = connect[i*2]
        dist[connect[i*2 - 1]][connect[0]] = connect[i*2]
        
print(dist)