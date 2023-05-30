import { StatusBar } from 'expo-status-bar';
import React from 'react';
import { Dimensions, StyleSheet, Text, View, Image } from 'react-native';
import DetailProfileCardView from './DetailProfileCardView';

export default function CardViewProfile() {
  return (
    <View style={styles.container}>
      <View style={styles.divFirstPart}>
        <Image source={require('../../assets/profile_photo_test.jpg')} style={styles.imageProfile}/>
        <Text>Jérémy</Text>
      </View>
      <View>
        <View style={styles.divDetailPart}>
          <DetailProfileCardView description="Reviews" value={2} icon="" hasBorder={true} hasIcon={false}/>
        </View>
        <View style={styles.divDetailPart}>
          <DetailProfileCardView description="Rating" value={5.0} icon='../../assets/star.png' hasBorder={true} hasIcon={true}/>
        </View>
        <View style={styles.divDetailPart}>
          <DetailProfileCardView description="Years hosting" value={3} icon="" hasBorder={false} hasIcon={false}/>
        </View>
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
    borderWidth: 1,
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
  divDetailPart: {
    marginVertical:3,
    paddingHorizontal:20
  },
  imageProfile: {
    width: '60%',
    height: '60%',
    margin: 20,
    borderWidth: 1,
    borderColor:'transparent',
    borderRadius: 100
  },
  

});
