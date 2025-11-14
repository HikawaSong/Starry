package com.star.starry;


import org.jboss.jandex.Index;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StringUtils;

import java.sql.Array;
import java.util.*;


public class DemoTest {

    public int minSubArrayLen(int target, int[] nums) {
        Deque<Integer> queue = new ArrayDeque<>();
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for (int num : nums) {
            sum += num;
            queue.add(num);

            while (sum >= target) {
                result = Math.min(result, queue.size());
                sum -= queue.removeFirst();
            }

        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }


    @Test
    void demoTest() {

        Assertions.assertEquals(3, minSubArrayLen(11, new int[]{1, 2, 3, 4, 5}));
        Assertions.assertEquals(2, minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        Assertions.assertEquals(0, minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1,}));
    }
}
