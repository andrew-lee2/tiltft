import React from "react";

function getRatingStr(rating) {
  // could be between -8 and 8 with -8 being the worst
  if (rating < -4) {
    return 'Definitely tilted'
  } else if (rating < -2) {
    return 'Might be tilted'
  } else if (rating < 2) {
    return 'Probably not tilted!'
  } else if (rating < 4) {
    return 'Not tilted!'
  } else {
    return 'Definitely not tilted!'
  }
}


// TODO add for error
export default function ResultsDisplay(props) {
  const rating = props.rating;
  const isLoaded = props.isLoaded;
  const error = props.error;
  let ratingValue = null;

  if (props.rating) {
    ratingValue = rating['rating']
  }

  if (isLoaded && ratingValue) {
    return (
      <div>
        <div>
          Result:
        </div>
        <div>
          {getRatingStr(ratingValue)}
        </div>
      </div>
    )
  } else if (error) {
    return (
      <p>
        An error has occured, please try again.
      </p>
    )
  } else {
    return null;
  }
}