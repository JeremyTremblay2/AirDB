import React from 'react';
import { Dimensions, StyleSheet, Text, View, Image } from 'react-native';
import { AntDesign } from '@expo/vector-icons'; 


type CheckedInformationCellProps = {
    isChecked: Boolean,
    text: string
}

export default function CheckedInformationCell(props:CheckedInformationCellProps) {
  return (
    <View style={styles.container}>
        <AntDesign name="check" size={24} color="black" style={{ borderBottomWidth: props.isChecked ? 1 : 0 }}/>
        <Text>{props.text}</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    flexDirection: "row",
    alignItems: 'center',
    justifyContent: 'center',
  },
  
});
