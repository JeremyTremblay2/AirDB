import React from 'react';
import { Dimensions, StyleSheet, Text, View, Image } from 'react-native';

type CheckedInformationCellProps = {
    isChecked: Boolean,
    text: string
}

export default function CardViewProfile() {
  return (
    <View style={styles.container}>
        <Text>Informations confirmées de Jérémy</Text>
        
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
