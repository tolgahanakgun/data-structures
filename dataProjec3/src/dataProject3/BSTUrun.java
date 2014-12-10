package dataProject3;
import java.util.NoSuchElementException;

import sun.misc.Queue;

public class BSTUrun {
    private Urun root;
    
    // aðaç boþ mu ?
    public boolean isEmpty() {
        return size() == 0;
    }

    // aðaçtaki düðüm sayýsýný döndürür
    public int size() {
        return size(root);
    }

    // x düðümünün altýndaki düðüm sayýsýný döndürür
    private int size(Urun x) {
        if (x == null) return 0;
        else return x.getN();
    }
    
    /***********************************************************************
     *  Search BST for given key, and return associated value if found,
     *  return null if not found
     ***********************************************************************/
    
     // bu isme sahip ürün var mý?
     public boolean contains(String urunAdi) {
         return get(urunAdi) != null;
     }

     // ismi verilen ürünü döndürür yoksa null döndürür
     public Urun get(String urunAdi) {
         return get(root, urunAdi);
     }
     
     private Urun get(Urun x, String urunAdi) {
         if (x == null) return null;
         int cmp = urunAdi.compareTo(x.getUrunAdi());
         if      (cmp < 0) return get(x.getLeft(), urunAdi);
         else if (cmp > 0) return get(x.getRight(), urunAdi);
         else              return x;
     }
     
     /***********************************************************************
      *  Aðaca yeni düðüm ekleme
      *  Eðer eklenecek düðüm zaten aðaçta mevcut ise bilgileri güncellenir
      ***********************************************************************/
     
     public void put(Urun eklenecekUrun) {
        // if (val == null) { delete(key); return; }
         root = put(root, eklenecekUrun);
         assert check();
     }

     private Urun put(Urun root, Urun eklenecekUrun) {
         if (root == null) return eklenecekUrun;
         int cmp = eklenecekUrun.getUrunAdi().compareTo(root.getUrunAdi());
         if      (cmp < 0) root.setLeft(put(root.getLeft(),eklenecekUrun));
         else if (cmp > 0) root.setRight(put(root.getRight(),eklenecekUrun));
         else              root   = eklenecekUrun;
         root.setN(1 + size(root.getLeft()) + size(root.getRight()));
         return root;
     }
     
     /***********************************************************************
      *  Silme
      ***********************************************************************/
     public void deleteMin() {
         if (isEmpty()) throw new NoSuchElementException("Symbol table underflow");
         root = deleteMin(root);
         assert check();
     }
     
     private Urun deleteMin(Urun silinecekUrun) {
         if (silinecekUrun.getLeft() == null) return silinecekUrun.getRight();
         silinecekUrun.setLeft(deleteMin(silinecekUrun.getLeft()));
         silinecekUrun.setN(size(silinecekUrun.getLeft()) + size(silinecekUrun.getRight()) + 1);
         return silinecekUrun;
     }
     
     public void deleteMax() {
         if (isEmpty()) throw new NoSuchElementException("Symbol table underflow");
         root = deleteMax(root);
         assert check();
     }
     
     private Urun deleteMax(Urun silinecekUrun) {
         if (silinecekUrun.getRight() == null) return silinecekUrun.getLeft();
         silinecekUrun.setRight(deleteMax(silinecekUrun.getRight()));
         silinecekUrun.setN(size(silinecekUrun.getLeft()) + size(silinecekUrun.getRight()) + 1);
         return silinecekUrun;
     }
     
     public void delete(String urunAdi) {
         root = delete(root, urunAdi);
         assert check();
     }
     
     private Urun delete(Urun root, String urunAdi) {
         if (root == null) return null;
         int cmp = urunAdi.compareTo(root.getUrunAdi());
         if      (cmp < 0) root.setLeft(delete(root.getLeft(),  urunAdi));
         else if (cmp > 0) root.setRight(delete(root.getRight(), urunAdi));
         else { 
             if (root.getRight() == null) return root.getLeft();
             if (root.getLeft()  == null) return root.getRight();
             Urun t = root;
             root = min(root.getRight());
             root.setRight(deleteMin(t.getRight()));
             root.setLeft(t.getLeft());
         } 
         root.setN(size(root.getLeft()) + size(root.getRight()) + 1);
         return root;
     }
     
     /***********************************************************************
      *  Min, max, floor, and ceiling
      ***********************************************************************/
      public String min() {
          if (isEmpty()) return null;
          return min(root).getUrunAdi();
      } 

      private Urun min(Urun x) { 
          if (x.getLeft() == null) return x; 
          else                return min(x.getLeft()); 
      } 

      public String max() {
          if (isEmpty()) return null;
          return max(root).getUrunAdi();
      } 

      private Urun max(Urun x) { 
          if (x.getRight() == null) return x; 
          else                 return max(x.getRight()); 
      } 

      public String floor(String urunAdi) {
          Urun x = floor(root, urunAdi);
          if (x == null) return null;
          else return x.getUrunAdi();
      } 

      private Urun floor(Urun x, String urunAdi) {
          if (x == null) return null;
          int cmp = urunAdi.compareTo(x.getUrunAdi());
          if (cmp == 0) return x;
          if (cmp <  0) return floor(x.getLeft(), urunAdi);
          Urun t = floor(x.getRight(), urunAdi); 
          if (t != null) return t;
          else return x; 
      } 

      public String ceiling(String urunAdi) {
          Urun x = ceiling(root, urunAdi);
          if (x == null) return null;
          else return x.getUrunAdi();
      }

      private Urun ceiling(Urun x, String urunAdi) {
          if (x == null) return null;
          int cmp = urunAdi.compareTo(x.getUrunAdi());
          if (cmp == 0) return x;
          if (cmp < 0) { 
              Urun t = ceiling(x.getLeft(), urunAdi); 
              if (t != null) return t;
              else return x; 
          } 
          return ceiling(x.getRight(), urunAdi); 
      }
      
      /***********************************************************************
       *  Rank and selection
       ***********************************************************************/
       public String select(int k) {
           if (k < 0 || k >= size()) return null;
           Urun x = select(root, k);
           return x.getUrunAdi();
       }

       // Return key of rank k. 
       private Urun select(Urun x, int k) {
           if (x == null) return null; 
           int t = size(x.getLeft()); 
           if      (t > k) return select(x.getLeft(),  k); 
           else if (t < k) return select(x.getRight(), k-t-1); 
           else            return x; 
       } 

       public int rank(String key) {
           return rank(key, root);
       } 

       // Number of keys in the subtree less than key.
       private int rank(String key, Urun x) {
           if (x == null) return 0; 
           int cmp = key.compareTo(x.getUrunAdi()); 
           if      (cmp < 0) return rank(key, x.getLeft()); 
           else if (cmp > 0) return 1 + size(x.getLeft()) + rank(key, x.getRight()); 
           else              return size(x.getLeft()); 
       } 
      
      /***********************************************************************
       *  Range count and range search.
       ***********************************************************************/
       public Iterable<String> keys() {
           return keys(min(), max());
       }

       @SuppressWarnings("unchecked")
	public Iterable<String> keys(String lo, String hi) {
           Queue<String> queue = new Queue<String>();
           keys(root, queue, lo, hi);
           return (Iterable<String>) queue;
       }
       
       private void keys(Urun x, Queue<String> queue, String lo, String hi) { 
           if (x == null) return; 
           int cmplo = lo.compareTo(x.getUrunAdi()); 
           int cmphi = hi.compareTo(x.getUrunAdi()); 
           if (cmplo < 0) keys(x.getLeft(), queue, lo, hi); 
           if (cmplo <= 0 && cmphi >= 0) queue.enqueue(x.getUrunAdi()); 
           if (cmphi > 0) keys(x.getRight(), queue, lo, hi); 
       }
       
       
       public int size(String lo, String hi) {
           if (lo.compareTo(hi) > 0) return 0;
           if (contains(hi)) return rank(hi) - rank(lo) + 1;
           else              return rank(hi) - rank(lo);
       }


       // height of this BST (one-node tree has height 0)
       public int height() { return height(root); }
       private int height(Urun x) {
           if (x == null) return -1;
           return 1 + Math.max(height(x.getLeft()), height(x.getRight()));
       }


       // level order traversal
       @SuppressWarnings("unchecked")
	public Iterable<String> levelOrder() throws InterruptedException {
           Queue<String> keys = new Queue<String>();
           Queue<Urun> queue = new Queue<Urun>();
           queue.enqueue(root);
           while (!queue.isEmpty()) {
               Urun x = queue.dequeue();
               if (x == null) continue;
               keys.enqueue(x.getUrunAdi());
               queue.enqueue(x.getLeft());
               queue.enqueue(x.getRight());
           }
           return (Iterable<String>) keys;
       }
       
       /*************************************************************************
        *  Check integrity of BST data structure
        *************************************************************************/
        private boolean check() {
            if (!isBST())            System.err.println("Not in symmetric order");
            if (!isSizeConsistent()) System.err.println("Subtree counts not consistent");
            if (!isRankConsistent()) System.err.println("Ranks not consistent");
            return isBST() && isSizeConsistent() && isRankConsistent();
        }

        // does this binary tree satisfy symmetric order?
        // Note: this test also ensures that data structure is a binary tree since order is strict
        private boolean isBST() {
            return isBST(root, null, null);
        }

        // is the tree rooted at x a BST with all keys strictly between min and max
        // (if min or max is null, treat as empty constraint)
        // Credit: Bob Dondero's elegant solution
        private boolean isBST(Urun x, String min, String max) {
            if (x == null) return true;
            if (min != null && x.getUrunAdi().compareTo(min) <= 0) return false;
            if (max != null && x.getUrunAdi().compareTo(max) >= 0) return false;
            return isBST(x.getLeft(), min, x.getUrunAdi()) && isBST(x.getRight(), x.getUrunAdi(), max);
        } 

        // are the size fields correct?
        private boolean isSizeConsistent() { return isSizeConsistent(root); }
        private boolean isSizeConsistent(Urun x) {
            if (x == null) return true;
            if (x.getN() != size(x.getLeft()) + size(x.getRight()) + 1) return false;
            return isSizeConsistent(x.getLeft()) && isSizeConsistent(x.getRight());
        } 

        // check that ranks are consistent
        private boolean isRankConsistent() {
            for (int i = 0; i < size(); i++)
                if (i != rank(select(i))) return false;
            for (String key : keys())
                if (key.compareTo(select(rank(key))) != 0) return false;
            return true;
        }

}
