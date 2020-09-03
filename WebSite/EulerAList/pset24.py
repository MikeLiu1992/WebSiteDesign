from itertools import permutations

myints = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
cnt = 0
for i in permutations(myints):
  cnt += 1
  if cnt >= 1000000:
    print(i)
    break