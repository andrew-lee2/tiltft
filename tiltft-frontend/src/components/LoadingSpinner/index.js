import {WiredSpinner} from "react-wired-elements";
import React from "react";

export default function LoadingSpinner(props) {
  if (props.isLoading) {
    return (
      <WiredSpinner
        duration={1400}
        spinning
      />
    );
  } else {
    return null;
  }
}
