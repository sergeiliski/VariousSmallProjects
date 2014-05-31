using Android.App;
using Android.Content;
using Android.OS;
using Android.Runtime;
using Android.Views;
using Android.Widget;
using System;

namespace WelcomeToAndroid {
    [Activity(Label = "WelcomeToAndroid", MainLauncher = true, Icon = "@drawable/icon")]
    public class Welcome : Activity {
        protected override void OnCreate(Bundle bundle) {
            base.OnCreate(bundle);

            SetContentView(Resource.Layout.Main);

            var aLabel = FindViewById<TextView>(Resource.Id.Greeting);
            var aButton = FindViewById<Button>(Resource.Id.ClickMe);
            aButton.Click += (sender, e) => {
                aLabel.Text = "You clicked me D:";
            };
        }
    }
}