# LabelEditText

[![](https://jitpack.io/v/Egi10/LabelEditText.svg)](https://jitpack.io/#Egi10/LabelEditText)

## Add Dependencies

1. Add it in your root **build.gradle** at the end of repositories:
```gradle	
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

2. on module app **build.gradle** 
```gradle
implementation 'com.github.Egi10:LabelEditText:v0.0.2-beta.1'
implementation 'com.google.android.material:material:1.2.1'
```

3. Change Thema In **style.xml**
```xml
<resources>
    <!-- Base application theme. -->
    <style name="AppTheme" parent="Theme.MaterialComponents.Light.DarkActionBar">
        <!-- Customize your theme here. -->
        <item name="colorPrimary">@color/colorPrimary</item>
        <item name="colorPrimaryDark">@color/colorPrimaryDark</item>
        <item name="colorAccent">@color/colorAccent</item>
    </style>
</resources>
```

## Layout

add code on your layout
```xml
<id.buaja.label.LabelEditText
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_margin="20dp"
    app:errorText="Ada Apa Ya"
    app:errorTextEnabled="true"
    app:hint="Masukan Aja Dulu"
    app:inputType="text"
    app:labelText="Coba Aja" />
```

## Screenshoot

<img src="https://github.com/Egi10/LabelEditText/blob/master/screenshoot/Screenshot_1600409173.png" width="250">
