class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        N = len(needle)
        M = len(haystack)
        for i in range(M):
            if haystack[i : i+N] == needle:
                return i
        return -1