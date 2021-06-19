from collections import deque

MAX = 200000

check = [False] * (MAX+1)
dist = [-1]*(MAX + 1)

n,m = map(int, input().split())
check[n] = True
dist[n] = 0

q = deque() # de queue?   queue class인가?
q.append(n)
while q:
    now = q.popleft()
    for nxt in [now-1, now+1, now*2]:
        if 0 <= nxt <= MAX and check[nxt] == False:  # nxt 값( n-1, n+1, 2n)이 MAX 사이고 방문한 적이 없다면
            check[nxt] = True
            dist[nxt] = dist[nxt] +1
            q.append(nxt)
print(dist[m])
