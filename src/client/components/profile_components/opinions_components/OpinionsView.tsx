import React from 'react';
import { StyleSheet, Text, View, Image, FlatList, SafeAreaView, Button, Pressable } from 'react-native';
import { Int32 } from 'react-native/Libraries/Types/CodegenTypes';
import OpinionCell from './OpinionCell'

type OpinionsViewItemProps = {
    name: string,
}

export default function OpinionsView(props : OpinionsViewItemProps) {
  return (
    <SafeAreaView>
      <View>
          <Text style={[styles.title, styles.margin]}>Avis de {props.name}</Text>
          <FlatList data={[1,2,3,4]} renderItem={OpinionCell} horizontal={true} />
          <View style={[styles.center, styles.margin]}>
            <Pressable style={styles.button}>
              <Text style={styles.text}>Voir les 7 avis</Text>
            </Pressable>
          </View>
          
      </View>
    </SafeAreaView>
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
  center: {
    alignItems:'center'
  },
  button: {
    alignItems: 'center',
    justifyContent: 'center',
    paddingVertical: 12,
    paddingHorizontal: 32,
    borderRadius: 4,
    backgroundColor: '#F9429E',
    maxWidth:'50%'
  },
  text: {
    fontSize: 16,
    lineHeight: 21,
    fontWeight: 'bold',
    letterSpacing: 0.25,
    color: 'white',
  }
})
