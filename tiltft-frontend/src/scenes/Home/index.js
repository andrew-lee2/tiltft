import React, { useState } from 'react';
import {WiredButton, WiredItem, WiredCombo, WiredInput, WiredSpinner} from "react-wired-elements";
import './styles.scss';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row'
import Col from 'react-bootstrap/Col'

function LoadingSpinner(props) {
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
function ResultsDisplay(props) {
  const rating = props.rating;
  const isLoaded = props.isLoaded;
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
  } else {
    return null;
  }
}

function Home() {
  const [summonerName, setSummonerName] = useState('');
  const [region, setRegion] = useState('');
  const [loading, setLoading] = useState(false);
  const [loaded, setLoaded] = useState(false);
  const [error, setError] = useState(false);
  const [rating, setRating] = useState(null);

  const handleSummonerName = event => {
    setSummonerName(event.target.value);
  };

  const handleRegion = event => {
    setRegion(event.target.value);
  };

  const handleSubmit = () => {
    if (region !== '' && summonerName !== '') {
      setLoading(true);
      // TODO set timeout?
      fetch(`/api/v1/tft-summoner-rating/?summonerName=${summonerName}&region=${region['text']}`)
        .then(res => res.json())
        .then(
          (result) => {
            setLoaded(true);
            setLoading(false);
            setRating(result);
          },
          (error) => {
            setLoaded(true);
            setLoading(false);
            setError(error);
          }
        );
    }
  };

  return (
    // TODO center this
    <Container>
      <Col>
        <h2>
          Are you tilted?
        </h2>
        <Row>
          {/*// TODO make this wider*/}
          <Col>
            <WiredInput
              placeholder="Enter a summoner name"
              onChange={handleSummonerName}
              value={summonerName}
            />

          </Col>
          <Col>
            {/*TODO split this out*/}
            <WiredCombo
              popupBgColor="white"
              selectedBgColor="gray"
              onSelect={handleRegion}
              value={region}
            >
              <WiredItem value="NA1">
                NA1
              </WiredItem>
              <WiredItem value="BR1">
                BR1
              </WiredItem>
              <WiredItem value="EUN1">
                EUN1
              </WiredItem>
              <WiredItem value="EUW1">
                EUW1
              </WiredItem>
              <WiredItem value="JP1">
                JP1
              </WiredItem>
              <WiredItem value="KR">
                KR
              </WiredItem>
              <WiredItem value="LA1">
                LA1
              </WiredItem>
              <WiredItem value="LA2">
                LA2
              </WiredItem>
              <WiredItem value="OC1">
                OC1
              </WiredItem>
              <WiredItem value="RU">
                RU
              </WiredItem>
              <WiredItem value="TR1">
                TR1
              </WiredItem>
            </WiredCombo>
          </Col>
          <Col>
            <WiredButton
              onClick={handleSubmit}
            >
              Submit
            </WiredButton>
          </Col>

        </Row>
      </Col>

      <LoadingSpinner
        isLoading={loading}
      />

      <ResultsDisplay
        isLoaded={loaded}
        rating={rating}
      />

    </Container>

  );
}

export default Home;