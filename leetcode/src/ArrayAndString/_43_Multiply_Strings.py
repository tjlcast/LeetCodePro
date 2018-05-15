class Solution(object):
    def multiply(self, num1, num2):
        """
        :type num1: str
        :type num2: str
        :rtype: str
        """
        if num1=='0' or num2=='0' or num1==None or num2==None:
            return '0'

        num1 = num1[::-1]
        num2 = num2[::-1]

        mul = [([0] * (len(num1)+len(num2))) for i in range(len(num2))]

        # to mul each element of num2 to num1
        for row in range(len(num2)):
            for col in range(len(num1)):
                mul[row][col+row] = int(num1[col]) * int(num2[row])

        # add each list of num1
        count = [0]*(len(num1)+len(num2))
        for col in range(len(num1)+len(num2)):
            sum = 0
            for row in range(len(num2)):
                sum+=mul[row][col]
            count[col] = sum

        # to compute list sum
        carr = 0
        for col in range(len(count)):
            val = count[col]+carr
            count[col] = val % 10
            carr = val / 10
        if carr!=0 :
            count[len(count)-1] = carr

        ans = ''.join(map(str, count)).rstrip('0')
        ans = ans[::-1]
        return ans


num1 = "9"
num2 = "99"
ans = Solution().multiply(num1, num2)
print(ans)