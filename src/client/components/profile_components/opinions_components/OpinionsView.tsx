import React from 'react';
import { StyleSheet, Text, View, Image, FlatList } from 'react-native';
import { Int32 } from 'react-native/Libraries/Types/CodegenTypes';
import OpinionCell from './OpinionCell'

type OpinionsViewItemProps = {
    name: string,
}

export default function OpinionsView(props : OpinionsViewItemProps) {
  return (
    <View>
        <Text style={[styles.title, styles.margin]}>Avis de {props.name}</Text>
        <FlatList data={[1,2,3,4]} renderItem={OpinionCell}/>
    </View>
  );
}

const styles = StyleSheet.create({
  title:{
    fontSize:25,
    fontWeight:'bold'
  },
  margin:{
    marginHorizontal:20,
    marginVertical:5
  },
})
