# Basic BMI Calculator using Kotlin and Material Components

A simple native Android BMI calculator built with Kotlin, XML layouts, and Material components. The app lets users enter weight in kilograms and height in feet and inches, then calculates Body Mass Index (BMI), shows the weight category, and displays short health guidance based on the result.

## Overview

This project is a lightweight Android application focused on one clear use case:

- Enter body weight in `kg`
- Enter height in `ft` and `in`
- Calculate BMI using metric conversion
- Show the BMI category on a visual result bar
- Display a health message for underweight, healthy, or overweight ranges
- Reset all inputs and results with one tap

## Features

- Native Android app written in Kotlin
- ViewBinding-enabled activity setup
- Material `TextInputLayout` input fields
- Custom styled result interface with BMI range bar
- BMI classification from severe underweight to obesity class III
- Basic input validation with user feedback via `Toast`
- Reset flow to clear both form values and calculated output

## Tech Stack

- Kotlin
- Android SDK 34
- Android Gradle Plugin 8.3.1
- Material Components
- ConstraintLayout
- ViewBinding

## Project Structure

```text
basic-bmi-calculator/
├── app/
│   ├── src/main/java/com/softylur/basiccalculator/
│   │   ├── MainActivity.kt
│   │   └── BMIActivity.kt
│   ├── src/main/res/layout/
│   │   ├── activity_main.xml
│   │   └── activity_bmi.xml
│   ├── src/main/res/values/
│   │   ├── strings.xml
│   │   ├── colors.xml
│   │   └── themes.xml
│   └── build.gradle.kts
├── gradle/
├── build.gradle.kts
├── settings.gradle.kts
└── README.md
```

## How It Works

The main BMI calculation flow lives in `MainActivity`.

1. The user enters:
   - Weight in kilograms
   - Height in feet
   - Height in inches
2. The app converts height to total inches.
3. Inches are converted to meters using `0.0254`.
4. BMI is calculated with:

```text
BMI = weightKg / (heightMeters * heightMeters)
```

5. The app then:
   - Marks the matching segment in the BMI result bar
   - Shows a text classification
   - Displays a health tip message

## BMI Categories Used

The current implementation classifies results as:

- `< 16.0` → Very Severely Underweight
- `16.0 - 16.9` → Severely Underweight
- `17.0 - 18.4` → Underweight
- `18.5 - 24.9` → Normal Weight
- `25.0 - 29.9` → Overweight
- `30.0 - 34.9` → Obese Class I
- `35.0 - 39.9` → Obese Class II
- `40+` → Obese Class III

## Getting Started

### Prerequisites

- Android Studio Hedgehog or newer recommended
- JDK 8 or newer
- Android SDK 34 installed

### Run Locally

1. Clone the repository:

```bash
git clone <your-repository-url>
cd basic-bmi-calculator
```

2. Open the project in Android Studio.

3. Let Gradle sync complete.

4. Run the app on an emulator or physical Android device.

### Build from Command Line

```bash
./gradlew assembleDebug
```

## Key Files

- `app/src/main/java/com/softylur/basiccalculator/MainActivity.kt`
  Handles user input, BMI calculation, validation, category selection, and reset behavior.

- `app/src/main/java/com/softylur/basiccalculator/BMIActivity.kt`
  Registered in the manifest, but currently not used as the main calculation flow.

- `app/src/main/res/layout/activity_main.xml`
  Defines the primary BMI calculator interface.

- `app/src/main/res/values/strings.xml`
  Stores app labels and health guidance messages.

## Current Notes

- The launcher title in resources is `Basic Calculator`, while the primary screen is a BMI calculator.
- `BMIActivity` exists in the project but is not currently part of the active user flow.
- The app uses direct activity logic without a separate architecture layer, which keeps the project simple and beginner-friendly.

## Possible Improvements

- Format BMI output to a fixed number of decimal places
- Extract repeated UI reset logic into helper methods
- Add unit tests for BMI calculations and range mapping
- Support metric and imperial weight/height options
- Improve accessibility and string localization
- Align app name and branding consistently across resources

## License

This project is currently unlicensed. Add a license file if you plan to distribute or open-source it publicly.
