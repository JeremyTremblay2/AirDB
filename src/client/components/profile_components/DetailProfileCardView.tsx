import React from 'react';
import { Dimensions, StyleSheet, Text, View, Image } from 'react-native';
import { Int32 } from 'react-native/Libraries/Types/CodegenTypes';

type DetailProfileCardItemProps = {
    description: String,
    value: Int32,
    icon: String,
    hasBorder: Boolean;
    hasIcon: Boolean
}

export default function CardViewProfile(props : DetailProfileCardItemProps) {
  return (
    <View  style={[styles.border, { borderBottomWidth: props.hasBorder ? 1 : 0 }]}>
      <View>
        <Text>{props.value}</Text>
      </View>
        <Text>{props.description}</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  border: {
    borderColor: "thistle",
  },
  /*firstDiv:{
    flex:1,
    flexDirection:'row',
    justifyContent: 'center',
    maxWidth:'30%'
  },*/
  icon:{
    maxHeight: 20,
    maxWidth: 20
  }
})
