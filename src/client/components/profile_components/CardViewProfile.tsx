import { StatusBar } from 'expo-status-bar';
import React from 'react';
import { Dimensions, StyleSheet, Text, View, Image } from 'react-native';
import DetailProfileCardView from './DetailProfileCardView';

export default function CardViewProfile() {
  return (
    <View style={styles.container}>
      <View style={styles.divFirstPart}>
        <Image source={require('../../assets/adaptive-icon.png')} style={styles.imageProfile}/>
        <Text>Jérémmy</Text>
      </View>
      <View>
        <DetailProfileCardView description="Reviews" value={2} icon="" hasBorder={true}/>
        <DetailProfileCardView description="Rating" value={5.0} icon="" hasBorder={true}/>
        <DetailProfileCardView description="Years hosting" value={3} icon="" hasBorder={false}/>
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    flexDirection: "row",
    alignItems: 'center',
    justifyContent: 'center',
    borderColor: "#000000",
    borderWidth: 2,
    maxHeight: Dimensions.get('window').height * 0.30,
    borderRadius: 20
  },
  divFirstPart: {
    flex: 1,
    flexDirection: "column",
    alignItems: 'center',
    justifyContent: 'center',
    maxWidth: '60%',
  },
  imageProfile: {
    width: 200,
    height: '70%',
    margin: 20
  },

});
