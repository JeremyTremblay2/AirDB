import React from 'react';
import { StyleSheet, Text, View } from 'react-native';
import { SafeAreaProvider } from 'react-native-safe-area-context';
import Navigation from './navigation/Navigation';

export default function App() {
  return (
    <SafeAreaProvider>
      <Navigation>
      </Navigation>
    </SafeAreaProvider>
  );
}

// headerShown
const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
});
