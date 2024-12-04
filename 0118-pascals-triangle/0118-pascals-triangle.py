class Solution(object):
    def generate(self, numRows):
        """
        :type numRows: int
        :rtype: List[List[int]]
        """
        l1 = [[1]]
        
        for i in range(1, numRows):
            l2 = []
            l2.append(1)
            for j in range(1, i):
                l2.append(l1[i-1][j-1] + l1[i-1][j])
            l2.append(1)
            l1.append(l2)
        return l1
        