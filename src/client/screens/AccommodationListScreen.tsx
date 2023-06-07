import React from "react";
import { View, Text, StyleSheet, FlatList } from "react-native";
import AccommodationListItem from "../components/AccommodationListItem";
import Stub from "../assets/Stub";

export default function AccomodationListScreen() {
    return (
        <View style={styles.container}>
            <View style={styles.centered}>
                <Text style={styles.title}>A list of accomodation !</Text>
                <FlatList data={Stub.ACCOMMODATION_LIST} renderItem={AccommodationListItem}
                          keyExtractor={(item: Accommodation) => item.id}/>
            </View>
        </View>
    )
};

const styles = StyleSheet.create({
    container: {
        flex: 1,
    },
    centered: {
        alignItems: "center"
    },
    title: {
        fontSize: 20
    }
});