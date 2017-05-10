class Solution(object):
    def findSubstring(self, s, words):
        """
        :type s: str
        :type words: List[str]
        :rtype: List[int]
        """
        ans = []

        wordLen = len(words[0])
        counts = {}
        for word in words:
            counts[word] = counts.get(word, 0) + 1

        for i in range(len(s)):
            copy = {}
            isSame = True
            j = i + wordLen*len(words)
            if j > len(s):
                continue
            k = i
            while k+wordLen<=j:
                key = s[k: k+wordLen]
                if counts.has_key(key) is False or counts.get(key)<=copy.get(key):
                    isSame = False
                    break
                else:
                    copy[key] = copy.get(key, 0)+1
                k += wordLen

            if isSame is True:
                ans.append(i)
        return ans


Solution().findSubstring("barfoothefoobarman", ["foo","bar"])



