/*
 * Orika - simpler, better and faster Java bean mapping
 * 
 * Copyright (C) 2011 Orika authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ma.glasnost.orika.test.util;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

import junit.framework.Assert;
import ma.glasnost.orika.metadata.MapperKey;
import ma.glasnost.orika.metadata.TypeFactory;
import ma.glasnost.orika.util.SortedCollection;

import org.junit.Test;

/**
 * @author matt.deboer@gmail.com
 * 
 */
public class SortedCollectionTestCase {
    public static class A1 {
        
    }
    
    public static class A2 extends A1 {
        
    }
    
    public static class A3 extends A2 {
        
    }
    
    public static class A4 extends A3 {
        
    }
    
    public static class A5 extends A4 {
        
    }
    
    public static class B1 {
        
    }
    
    public static class B2 extends B1 {
        
    }
    
    public static class B3 extends B2 {
        
    }
    
    public static class B4 extends B3 {
        
    }
    
    public static class B5 extends B4 {
        
    }
    
    public static class C1 {
        
    }
    
    public static class C2 extends C1 {
        
    }
    
    public static class C3 extends C2 {
        
    }
    
    public static class C4 extends C3 {
        
    }
    
    public static class C5 extends C4 {
        
    }
    
    public static class D1 {
        
    }
    
    public static class D2 extends D1 {
        
    }
    
    public static class D3 extends D2 {
        
    }
    
    public static class D4 extends D3 {
        
    }
    
    public static class D5 extends D4 {
        
    }
    
    @Test
    public void testOrdering2() {
        
        Set<MapperKey> set = new HashSet<MapperKey>();
        
        set.add(new MapperKey(TypeFactory.valueOf(A1.class), TypeFactory.valueOf(B1.class)));
        set.add(new MapperKey(TypeFactory.valueOf(A2.class), TypeFactory.valueOf(B2.class)));
        set.add(new MapperKey(TypeFactory.valueOf(A3.class), TypeFactory.valueOf(B3.class)));
        set.add(new MapperKey(TypeFactory.valueOf(A4.class), TypeFactory.valueOf(B4.class)));
        set.add(new MapperKey(TypeFactory.valueOf(A5.class), TypeFactory.valueOf(B5.class)));
        
        set.add(new MapperKey(TypeFactory.valueOf(A1.class), TypeFactory.valueOf(C1.class)));
        set.add(new MapperKey(TypeFactory.valueOf(A2.class), TypeFactory.valueOf(C2.class)));
        set.add(new MapperKey(TypeFactory.valueOf(A3.class), TypeFactory.valueOf(C3.class)));
        set.add(new MapperKey(TypeFactory.valueOf(A4.class), TypeFactory.valueOf(C4.class)));
        set.add(new MapperKey(TypeFactory.valueOf(A5.class), TypeFactory.valueOf(C5.class)));
        
        set.add(new MapperKey(TypeFactory.valueOf(A1.class), TypeFactory.valueOf(D1.class)));
        set.add(new MapperKey(TypeFactory.valueOf(A2.class), TypeFactory.valueOf(D2.class)));
        set.add(new MapperKey(TypeFactory.valueOf(A3.class), TypeFactory.valueOf(D3.class)));
        set.add(new MapperKey(TypeFactory.valueOf(A4.class), TypeFactory.valueOf(D4.class)));
        set.add(new MapperKey(TypeFactory.valueOf(A5.class), TypeFactory.valueOf(D5.class)));
        
        set.add(new MapperKey(TypeFactory.valueOf(B1.class), TypeFactory.valueOf(C1.class)));
        set.add(new MapperKey(TypeFactory.valueOf(B2.class), TypeFactory.valueOf(C2.class)));
        set.add(new MapperKey(TypeFactory.valueOf(B3.class), TypeFactory.valueOf(C3.class)));
        set.add(new MapperKey(TypeFactory.valueOf(B4.class), TypeFactory.valueOf(C4.class)));
        set.add(new MapperKey(TypeFactory.valueOf(B5.class), TypeFactory.valueOf(C5.class)));
        
        set.add(new MapperKey(TypeFactory.valueOf(B1.class), TypeFactory.valueOf(D1.class)));
        set.add(new MapperKey(TypeFactory.valueOf(B2.class), TypeFactory.valueOf(D2.class)));
        set.add(new MapperKey(TypeFactory.valueOf(B3.class), TypeFactory.valueOf(D3.class)));
        set.add(new MapperKey(TypeFactory.valueOf(B4.class), TypeFactory.valueOf(D4.class)));
        set.add(new MapperKey(TypeFactory.valueOf(B5.class), TypeFactory.valueOf(D5.class)));
        
        set.add(new MapperKey(TypeFactory.valueOf(C1.class), TypeFactory.valueOf(D1.class)));
        set.add(new MapperKey(TypeFactory.valueOf(C2.class), TypeFactory.valueOf(D2.class)));
        set.add(new MapperKey(TypeFactory.valueOf(C3.class), TypeFactory.valueOf(D3.class)));
        set.add(new MapperKey(TypeFactory.valueOf(C4.class), TypeFactory.valueOf(D4.class)));
        set.add(new MapperKey(TypeFactory.valueOf(C5.class), TypeFactory.valueOf(D5.class)));
        
        // ~~~~~~~~~~~~~~~~~~
        // Add some mismatched mapper keys, in attempt to confuse the ordering
        // process
        
        set.add(new MapperKey(TypeFactory.valueOf(A1.class), TypeFactory.valueOf(B5.class)));
        set.add(new MapperKey(TypeFactory.valueOf(A2.class), TypeFactory.valueOf(B4.class)));
        set.add(new MapperKey(TypeFactory.valueOf(A4.class), TypeFactory.valueOf(B2.class)));
        set.add(new MapperKey(TypeFactory.valueOf(A5.class), TypeFactory.valueOf(B1.class)));
        
        set.add(new MapperKey(TypeFactory.valueOf(A1.class), TypeFactory.valueOf(C5.class)));
        set.add(new MapperKey(TypeFactory.valueOf(A2.class), TypeFactory.valueOf(C4.class)));
        set.add(new MapperKey(TypeFactory.valueOf(A4.class), TypeFactory.valueOf(C2.class)));
        set.add(new MapperKey(TypeFactory.valueOf(A5.class), TypeFactory.valueOf(C1.class)));
        
        set.add(new MapperKey(TypeFactory.valueOf(A1.class), TypeFactory.valueOf(D5.class)));
        set.add(new MapperKey(TypeFactory.valueOf(A2.class), TypeFactory.valueOf(D4.class)));
        set.add(new MapperKey(TypeFactory.valueOf(A4.class), TypeFactory.valueOf(D2.class)));
        set.add(new MapperKey(TypeFactory.valueOf(A5.class), TypeFactory.valueOf(D1.class)));
        
        set.add(new MapperKey(TypeFactory.valueOf(B1.class), TypeFactory.valueOf(C5.class)));
        set.add(new MapperKey(TypeFactory.valueOf(B2.class), TypeFactory.valueOf(C4.class)));
        set.add(new MapperKey(TypeFactory.valueOf(B4.class), TypeFactory.valueOf(C2.class)));
        set.add(new MapperKey(TypeFactory.valueOf(B5.class), TypeFactory.valueOf(C1.class)));
        
        set.add(new MapperKey(TypeFactory.valueOf(B1.class), TypeFactory.valueOf(D5.class)));
        set.add(new MapperKey(TypeFactory.valueOf(B2.class), TypeFactory.valueOf(D4.class)));
        set.add(new MapperKey(TypeFactory.valueOf(B4.class), TypeFactory.valueOf(D2.class)));
        set.add(new MapperKey(TypeFactory.valueOf(B5.class), TypeFactory.valueOf(D1.class)));
        
        set.add(new MapperKey(TypeFactory.valueOf(C1.class), TypeFactory.valueOf(D5.class)));
        set.add(new MapperKey(TypeFactory.valueOf(C2.class), TypeFactory.valueOf(D4.class)));
        set.add(new MapperKey(TypeFactory.valueOf(C4.class), TypeFactory.valueOf(D2.class)));
        set.add(new MapperKey(TypeFactory.valueOf(C5.class), TypeFactory.valueOf(D1.class)));
        
        SortedCollection<MapperKey> queue = new SortedCollection<MapperKey>(new Comparator<MapperKey>() {
            
            public int compare(MapperKey key1, MapperKey key2) {
                
                if (key1.equals(key2)) {
                    return 0;
                } else if ((key1.getAType().isAssignableFrom(key2.getAType()) && key1.getBType().isAssignableFrom(key2.getBType()))
                        || (key1.getAType().isAssignableFrom(key2.getBType()) && key1.getBType().isAssignableFrom(key2.getAType()))) {
                    return 1;
                } else if ((key2.getAType().isAssignableFrom(key1.getAType()) && key2.getBType().isAssignableFrom(key1.getBType()))
                        || (key2.getAType().isAssignableFrom(key1.getBType()) && key2.getBType().isAssignableFrom(key1.getAType()))) {
                    return -1;
                } else {
                    /*
                     * Unrelated, thus they should be considered "equal" in
                     * regards to sorting
                     */
                    return 0;
                }
                
            }
            
        });
        
        for (MapperKey key : set) {
            queue.add(key);
        }
        
        Assert.assertEquals(set.size(), queue.size());
        
        Set<MapperKey> seen = new HashSet<MapperKey>();
        for (MapperKey key : queue) {
            for (MapperKey seenKey : seen) {
                if ((seenKey.getAType().isAssignableFrom(key.getAType()) && seenKey.getBType().isAssignableFrom(key.getBType()))
                        || (seenKey.getAType().isAssignableFrom(key.getBType()) && seenKey.getBType().isAssignableFrom(key.getAType()))) {
                    Assert.fail("saw a parent " + seenKey + " before it's child " + key);
                }
            }
            seen.add(key);
        }
    }
}
