from snowballstemmer import MaoriStemmer

stem = MaoriStemmer()
voc_path = 'voc.txt'
voc = []
with open(voc_path, 'r') as f:
    for line in f.readlines():
        voc.append(line.strip())

output = stem.stemWords(voc)
out_path = 'output.txt'
with open(out_path, 'w') as f:
    for word in output:
        f.write(str(word) + '\n')
