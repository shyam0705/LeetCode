class FoodRatings {
    
    class Pair{
        String type;
        int rating;
        String food;
        Pair(String food,String type,int rating)
        {
            this.food=food;
            this.type=type;
            this.rating=rating;
        }
        
    }
    HashMap<String,Pair>food_to_cusine;
    HashMap<String,PriorityQueue<Pair>>list;
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        food_to_cusine=new HashMap<>();
        list=new HashMap<>();
        int n=foods.length;
        for(int i=0;i<n;i++)
        {
            food_to_cusine.put(foods[i],new Pair(foods[i],cuisines[i],ratings[i]));
            if(list.containsKey(cuisines[i]))
            {
                list.get(cuisines[i]).add(food_to_cusine.get(foods[i]));
            }
            else
            {
                PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->{
                    if(b.rating==a.rating)
                    {
                        return a.food.compareTo(b.food);
                    }
                    return b.rating-a.rating;
                });
                pq.add(food_to_cusine.get(foods[i]));
                list.put(cuisines[i],pq);
            }
        }
        
    }
    
    public void changeRating(String food, int newRating) {
        Pair tmp=food_to_cusine.get(food);
        list.get(tmp.type).remove(tmp);
        tmp.rating=newRating;
        list.get(tmp.type).add(tmp);
    }
    
    public String highestRated(String cuisine) {
        return list.get(cuisine).peek().food;
    }
}

