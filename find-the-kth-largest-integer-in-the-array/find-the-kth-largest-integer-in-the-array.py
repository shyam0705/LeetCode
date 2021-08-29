class Solution:
    def kthLargestNumber(self, nums: List[str], k: int) -> str:
        n=len(nums);
        nums.sort(key = int)
        return nums[n-k];
        