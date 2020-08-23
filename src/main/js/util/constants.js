import React from 'react';

export const SKILLS = ["Java",
    "Javascript",
    "NodeJs",
    "ReactJs",
    "Angular",
    "Python",
    "AWS",
    "MySql",
    "NoSql"];

export const YEARS = ['< 1 year',
    '1 - 3 years',
    '3 - 5 years',
    '5 - 7 years',
    '7 - 9 years',
    '> 9 years'];

export const CITIES = ['Pune', 'Mumbai', 'Bengluru', 'Delhi', 'Hyderabad'];

export const ExperienceIcon = () => {
    return (<svg width="1em" height="1em" viewBox="0 0 16 16" className="bi bi-newspaper" fill="currentColor"
                 xmlns="http://www.w3.org/2000/svg">
        <path fillRule="evenodd"
              d="M0 2A1.5 1.5 0 0 1 1.5.5h11A1.5 1.5 0 0 1 14 2v12a1.5 1.5 0 0 1-1.5 1.5h-11A1.5 1.5 0 0 1 0 14V2zm1.5-.5A.5.5 0 0 0 1 2v12a.5.5 0 0 0 .5.5h11a.5.5 0 0 0 .5-.5V2a.5.5 0 0 0-.5-.5h-11z"/>
        <path fillRule="evenodd"
              d="M15.5 3a.5.5 0 0 1 .5.5V14a1.5 1.5 0 0 1-1.5 1.5h-3v-1h3a.5.5 0 0 0 .5-.5V3.5a.5.5 0 0 1 .5-.5z"/>
        <path
            d="M2 3h10v2H2V3zm0 3h4v3H2V6zm0 4h4v1H2v-1zm0 2h4v1H2v-1zm5-6h2v1H7V6zm3 0h2v1h-2V6zM7 8h2v1H7V8zm3 0h2v1h-2V8zm-3 2h2v1H7v-1zm3 0h2v1h-2v-1zm-3 2h2v1H7v-1zm3 0h2v1h-2v-1z"/>
    </svg>)
};

export const LocationIcon = () => {
    return (<svg width="1em" height="1em" viewBox="0 0 16 16" className="bi bi-geo-alt" fill="currentColor"
                 xmlns="http://www.w3.org/2000/svg">
        <path fillRule="evenodd"
              d="M8 16s6-5.686 6-10A6 6 0 0 0 2 6c0 4.314 6 10 6 10zm0-7a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
    </svg>);
};
