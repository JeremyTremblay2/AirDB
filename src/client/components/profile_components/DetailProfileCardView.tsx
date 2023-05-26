import React from 'react';
import { StyleSheet, Text, View, Image } from 'react-native';
import { Int32 } from 'react-native/Libraries/Types/CodegenTypes';

type DetailProfileCardItemProps = {
    description: String,
    value: Int32,
    icon: String,
    hasBorder: Boolean;
}

export default function CardViewProfile(props : DetailProfileCardItemProps) {
  return (
    <View  style={[styles.border, { borderBottomWidth: props.hasBorder ? 1 : 0 }]}>
        <Text>{props.value}</Text>
        <Text>{props.description}</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    flexDirection: "row",
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
  imageProfile: {
    width: 200,
    height: '20%',
  },
  border: ({
        borderColor: "thistle",
    })
})
