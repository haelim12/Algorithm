word = list(input())
word_alpha = []

for i in range(1, len(word) - 1):
    for j in range(i + 1, len(word)):
        cut1 = word[:i]
        cut2 = word[i:j]
        cut3 = word[j:]

        cut1 = cut1[::-1]
        cut2 = cut2[::-1]
        cut3 = cut3[::-1]

        word_alpha.append("".join(cut1 + cut2 + cut3))

word_alpha = sorted(word_alpha)
print(word_alpha[0])