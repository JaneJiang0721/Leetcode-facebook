/*15: 3Sum
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

version1: 01/06/2018
(1)Check two lists are equal should be using for loop in one lists, which would be time consuming. 
(2)The debug time is so long that I had to figure out a way to try to find the shortest way.
(3)java.util.concurrentmodificationexception – How to handle Concurrent Modification Exception
*/

    public List<List<Integer>> threeSum(int[] nums) {
        // in order to save time, we could store some values.
        //version 1: using hashmap, how to remove duplicate? [[-1,1,0],[-1,-1,2],[0,-1,1]]
        // Have a debug problem which cause a lot time.
        // I have problem in debugging where you don't know the exact procedure to go when adding system print out.
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return res;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.clear();
            for (int j = i+1; j < nums.length; j++) {
                //System.out.println(j);
                if(set.contains(-nums[i]-nums[j])) {
                    //System.out.println(nums[j]);
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(-nums[i]-nums[j]);
                    // for (int c : temp) {
                    //     System.out.println(c);
                    // }
                    if (res.isEmpty()) {
                        res.add(temp);
                    }
                    else {
                        boolean flag = false;
                        for (List<Integer> t : res) {
                            //System.out.println(nums[j]);
                            // for (int c : t) {
                            //     System.out.println("in result");
                            //     System.out.println(c);
                            // }
                            // System.out.println("in nums");
                            // System.out.println(nums[i]);
                            // System.out.println(nums[j]);
                            // System.out.println(t.contains(nums[i]));
                            // System.out.println(t.contains(nums[j]));
                            // in terms of checking two lists are equal
                            System.out.println(t.equals(temp));
                            if (t.equals(temp)) {
                                System.out.println("in loop");
                                System.out.println(nums[i]);
                                //continue;  
                                //res.add(temp);
                                flag = true;
                                break;
                            }
                         }
                    if (!flag) {
                                res.add(temp);
                            }
                    }

                }
                set.add(nums[j]);
            }
        }
        return res;
    }