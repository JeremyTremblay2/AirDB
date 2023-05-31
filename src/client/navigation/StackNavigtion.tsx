import React from "react";
import { createStackNavigator } from "@react-navigation/stack";
import { NavigationContainer } from "@react-navigation/native";
import ExploreScreen from "../screens/ExploreScreen";

export default function StackNavigation() {
    const Stack = createStackNavigator();
    return (
        <NavigationContainer>
            <Stack.Navigator initialRouteName="Explore">
                <Stack.Screen name="Explore" component={ExploreScreen}/>
                <Stack.Screen name="Wishlist" component={ExploreScreen}/>
                <Stack.Screen name="Profile" component={ExploreScreen}/>
            </Stack.Navigator>
        </NavigationContainer>
    )
}