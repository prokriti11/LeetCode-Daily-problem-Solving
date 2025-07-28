class Solution(object):
    def smallestStringWithSwaps(self, s, pairs):
        """
        :type s: str
        :type pairs: List[List[int]]
        :rtype: str
        """
        parent = list(range(len(s)))
        
        def find(x):
            if parent[x] != x:
                parent[x] = find(parent[x])
            return parent[x]
        
        def union(x, y):
            parent[find(x)] = find(y)
        
        for a, b in pairs:
            union(a, b)
        
        groups = defaultdict(list)
        for i in range(len(s)):
            groups[find(i)].append(i)
        
        res = list(s)
        for group in groups.values():
            chars = [s[i] for i in group]
            chars.sort()
            for i, ch in zip(sorted(group), chars):
                res[i] = ch
        
        return ''.join(res)