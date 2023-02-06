# 바이러스

c = int(input())
line = int(input())
graph = [[] for _ in range(c+1)]

for _ in range(line):
    v1, v2 = map(int, input().split())
    graph[v1].append(v2)
    graph[v2].append(v1)

# print(graph)

total = 0
visited = [False] * (c+1)

def dfs(start):
    visited[start] = True

    for i in graph[start]:
        if visited[i] == 0:
            dfs(i)
            i
dfs(1)
print(sum(visited)-1)