import React from "react";
import { View, Image, StyleSheet, Text } from "react-native";

type AccommodationListItemProps = {
  item: Accommodation;
}

export default function AccommodationListItem(props: AccommodationListItemProps) {
    return (
        <View>
            <View style={styles.container}>
                <View>
                    <Image
                        style={styles.teaserImage}
                        source={{
                        uri: 'https://reactnative.dev/img/tiny_logo.png',
                        }} />
                </View>
                <View>
                    <Text>Name : {props.item.name}</Text>
                    <Text>Name : {props.item.rating}</Text>
                    <Text>Near {props.item.location} host</Text>
                    <Text>{props.item.startDate.toDateString()}-{props.item.endDate.toDateString()}</Text>
                    <Text>{props.item.price} night</Text>
                </View>
            </View>
            <View style={styles.separator}/>
        </View>
    )
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        flexDirection: "column",
        marginVertical: "5%"
    },
    separator: {
        marginVertical: 4,
        backgroundColor: "rgba(255,255,255,0.3)",
        height: 1,
        width: '90%',
    },
    teaserImage: {
        borderRadius: 10,
        width: 50,
        height: 50,
    }
});