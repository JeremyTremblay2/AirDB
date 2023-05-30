import { createStackNavigator } from "@react-navigation/stack";
import AccommodationDetailsScreen from "../screens/AccommodationDetailsScreen";
import AccommodationListScreen from "../screens/AccommodationListScreen";


export default function AccomodationNavigator() {
    const Stack = createStackNavigator();
    return (
      <Stack.Navigator initialRouteName="AccomodationList">
        <Stack.Screen name="AccomodationList" component={AccommodationListScreen}/>
        <Stack.Screen name="AccomodationDetails" component={AccommodationDetailsScreen}/>
      </Stack.Navigator>
    )
  }