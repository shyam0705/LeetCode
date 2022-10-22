class Solution {
    
    class Node
    {
        int price;
        int amount;
        Node(int price,int amount)
        {
            this.price=price;
            this.amount=amount;
        }
    }
    
    //[[26,7,0],[16,1,1],[14,20,0],[23,15,1],[24,26,0],[19,4,1],[1,1,0]]
    //1 1,24 13,14 20
    //
    public int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<Node>sell=new PriorityQueue<>((a,b)->{
            return a.price-b.price;
        });
        PriorityQueue<Node>buy=new PriorityQueue<>((a,b)->{
            return b.price-a.price;
        });
        
        int n=orders.length;
        for(int i=0;i<n;i++)
        {
            int type=orders[i][2];
            int price=orders[i][0];
            int amount=orders[i][1];
            
            if(type==0)
            {
                while(amount>0 && !sell.isEmpty() && sell.peek().price<=price)
                {
                    Node tmp=sell.remove();
                    if(tmp.amount>amount)
                    {

                        sell.add(new Node(tmp.price,tmp.amount-amount));
                        amount=0;
                    }
                    else
                    {
                        amount=amount-tmp.amount;
                    }
                }
                if(amount>0)
                {
                    buy.add(new Node(price,amount));
                }
            }
            else
            {
                while(amount>0 && !buy.isEmpty() && buy.peek().price>=price)
                {
                    Node tmp=buy.remove();
                    if(tmp.amount>amount)
                    {

                        buy.add(new Node(tmp.price,tmp.amount-amount));
                        amount=0;
                    }
                    else
                    {
                        amount=amount-tmp.amount;
                    }
                }
                if(amount>0)
                {
                    sell.add(new Node(price,amount));
                }
            }
        }
        
        long ans=0;
        long mod=1000000007;
        // System.out.println("buy");
        while(!buy.isEmpty())
        {
            Node tmp=buy.remove();
            // System.out.println(tmp.amount);
            ans=(ans+tmp.amount)%mod;
        }
        // System.out.println("sell");
        while(!sell.isEmpty())
        {
            Node tmp=sell.remove();
            // System.out.println(tmp.amount);
            ans=(ans+tmp.amount)%mod;
        }
        return (int)ans;
    }
}