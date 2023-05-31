import React from "react";
import { View, Text, StyleSheet } from "react-native";

export default function WishlistScreen() {
    return (
        <View style={styles.container}>
            <View style={styles.centered}>
                <Text style={styles.title}>Your wishlist !</Text>
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