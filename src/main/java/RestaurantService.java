import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RestaurantService {
    private static List<Restaurant> restaurants = new ArrayList<>();

    public Restaurant findRestaurantByName(String restaurantName) throws Exception, RestaurantNotFoundException {
        for(int i=0;i<restaurants.size();i++){
            if(restaurants.get(i).getName().equals(restaurantName)){
                return restaurants.get(i);
            }else{
                throw  new RestaurantNotFoundException(restaurantName);
            }
        }
        return null;
    }


    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Restaurant removeRestaurant(String restaurantName) throws RestaurantNotFoundException, Exception {
        Restaurant restaurantToBeRemoved =  findRestaurantByName(restaurantName);
        restaurants.remove(restaurantToBeRemoved);
        return restaurantToBeRemoved;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }
}
