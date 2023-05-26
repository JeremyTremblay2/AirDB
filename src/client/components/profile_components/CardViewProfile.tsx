import { StatusBar } from 'expo-status-bar';
import React from 'react';
import { Dimensions, StyleSheet, Text, View, Image } from 'react-native';
import DetailProfileCardView from './DetailProfileCardView';

export default function CardViewProfile() {
  return (
    <View style={styles.container}>
      <View>
        <Image source={require('../../assets/adaptive-icon.png')} style={styles.imageProfile}/>
        <Text>Jérémmy</Text>
      </View>
      <View>
        <DetailProfileCardView description="Reviews" value={2} icon="" hasBorder={true} ></DetailProfileCardView>
        <DetailProfileCardView description="Rating" value={5.0} icon="" hasBorder={true} ></DetailProfileCardView>
        <DetailProfileCardView description="Years hosting" value={3} icon="" hasBorder={false} ></DetailProfileCardView>
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    flexDirection: "row",
    backgroundColor: '#000',
    alignItems: 'center',
    justifyContent: 'center',
    borderColor: "#000000",
    borderWidth: 2,
    borderRadius: Dimensions.get('window').height * 0.10
    
  },
  imageProfile: {
    width: 200,
    height: '20%',
  },
  border: {
    
  }
});
