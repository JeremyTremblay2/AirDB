import React from "react";
import { createBottomTabNavigator } from "@react-navigation/bottom-tabs";
import { NavigationContainer } from "@react-navigation/native";
import { FontAwesome } from '@expo/vector-icons';
import WishlistScreen from "../screens/WishlistScreen";
import ProfileScreen from "../screens/ProfileScreen";
import AccomodationNavigator from "./AccomodationNavigator";

function TabBarIcon(props: {
    name: React.ComponentProps<typeof FontAwesome>['name'];
    color: string;
}) {
    return <FontAwesome name={props.name} size={30} color={props.color} />;
}

export default function Navigation() {
    const BottomTabNavigator = createBottomTabNavigator();
    return (
        <NavigationContainer>
            <BottomTabNavigator.Navigator initialRouteName="Explore">
                <BottomTabNavigator.Screen name="Explore" component={AccomodationNavigator}
                                            options={{
                                                title: 'Explore',
                                                tabBarIcon: ({color}) => <TabBarIcon name="search" color={color}/>,
                                            }}/>
                <BottomTabNavigator.Screen name="Wishlist" component={WishlistScreen}
                                            options={{
                                                title: 'Wishlist',
                                                tabBarIcon: ({color}) => <TabBarIcon name="heart-o" color={color}/>,
                                            }}/>
                <BottomTabNavigator.Screen name="Profile" component={ProfileScreen}
                                            options={{
                                                title: 'Profile',
                                                tabBarIcon: ({color}) => <TabBarIcon name="user-circle-o" color={color}/>,
                                            }}/>
            </BottomTabNavigator.Navigator>
        </NavigationContainer>
    )
}